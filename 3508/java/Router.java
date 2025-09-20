import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Router {

    private final int maxMemory;
    private final Queue<Packet> queue;
    private final Map<Integer, Destination> packetsByDestination;

    public Router(int memoryLimit) {
        maxMemory = memoryLimit;
        queue = new LinkedList<>();
        packetsByDestination = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Destination dest = packetsByDestination.computeIfAbsent(destination, ignore -> new Destination());
        Packet p = new Packet(source, destination, timestamp);
        if (dest.contains(p)) {
            return false;
        }
        queue.offer(p);
        dest.add(p);
        if (queue.size() > maxMemory) {
            p = queue.poll();
            packetsByDestination.get(p.destination()).remove();
        }
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[] {};
        }
        Packet p = queue.poll();
        packetsByDestination.get(p.destination()).remove();
        return p.toArray();
    }

    public int getCount(int destination, int startTime, int endTime) {
        Destination dest = packetsByDestination.get(destination);
        if (dest == null) {
            return 0;
        }
        return dest.getCount(startTime, endTime);
    }

    /*
     * Data packet managed by router.
     */
    private static record Packet(int source, int destination, int timestamp) {

        int[] toArray() {
            return new int[] { source, destination, timestamp };
        }

    }

    /*
     * Destination machine for packets.
     */
    private static class Destination {

        private final List<Packet> orderedPackets;
        private final Set<Packet> uniquePackets;

        Destination() {
            this.orderedPackets = new ArrayList<>();
            this.uniquePackets = new HashSet<>();
        }

        boolean add(Packet packet) {
            if (uniquePackets.add(packet)) {
                orderedPackets.add(packet);
                return true;
            }
            return false;
        }

        boolean contains(Packet packet) {
            return uniquePackets.contains(packet);
        }

        void remove() {
            Packet packet = orderedPackets.remove(0);
            uniquePackets.remove(packet);
        }

        public int getCount(int startTime, int endTime) {
            if (orderedPackets.isEmpty()) {
                return 0;
            }
            int startIdx = bsIndexGreaterOrEqual(startTime);
            int endIdx = bsIndexLowerOrEqual(endTime);
            int count = endIdx - startIdx + 1;
            return Math.max(0, count);
        }

        private int bsIndexGreaterOrEqual(int value) {
            int result = orderedPackets.size();
            int left = 0;
            int right = orderedPackets.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (orderedPackets.get(mid).timestamp() >= value) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return result;
        }

        private int bsIndexLowerOrEqual(int value) {
            int result = -1;
            int left = 0;
            int right = orderedPackets.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (orderedPackets.get(mid).timestamp() <= value) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }

    }

}
