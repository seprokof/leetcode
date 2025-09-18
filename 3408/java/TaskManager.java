import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager {

    private final Map<Integer, Task> taskById;
    private final PriorityQueue<Task> tasks;

    public TaskManager(List<List<Integer>> tasks) {
        this.taskById = new HashMap<>(tasks.size());
        this.tasks = new PriorityQueue<>(tasks.size(), Comparator.reverseOrder());
        for (List<Integer> task : tasks) {
            add(task.getFirst(), task.get(1), task.getLast());
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskById.put(taskId, task);
        tasks.offer(new Task(task));
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskById.get(taskId);
        task.priority = newPriority;
        tasks.offer(new Task(task));
    }

    public void rmv(int taskId) {
        taskById.remove(taskId);
    }

    public int execTop() {
        while (!tasks.isEmpty() && !isValidTask(tasks.peek())) {
            tasks.poll();
        }
        if (tasks.isEmpty()) {
            return -1;
        }
        Task top = tasks.poll();
        taskById.remove(top.taskId);
        return top.userId;
    }

    private boolean isValidTask(Task task) {
        Task latest = taskById.get(task.taskId);
        if (latest == null) {
            return false;
        }
        return latest.priority == task.priority && latest.userId == task.userId;
    }

    private static class Task implements Comparable<Task> {

        private final int userId;
        private final int taskId;
        private int priority;

        Task(int userId, int taskId, int priority) {
            super();
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        Task(Task task) {
            super();
            this.userId = task.userId;
            this.taskId = task.taskId;
            this.priority = task.priority;
        }

        @Override
        public int compareTo(Task other) {
            int result = Integer.compare(this.priority, other.priority);
            if (result != 0) {
                return result;
            }
            return Integer.compare(this.taskId, other.taskId);
        }

    }

}
