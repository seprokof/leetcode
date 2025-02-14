import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        this.prefixProduct = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct = new ArrayList<>();
        } else {
            prefixProduct.add(num * (prefixProduct.isEmpty() ? 1 : prefixProduct.getLast()));
        }
    }

    public int getProduct(int k) {
        if (prefixProduct.size() < k) {
            return 0;
        }
        int startIdx = prefixProduct.size() - k - 1;
        return prefixProduct.getLast() / (startIdx < 0 ? 1 : prefixProduct.get(startIdx));
    }

}
