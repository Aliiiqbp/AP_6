package src.Model.Product;

import java.util.ArrayList;
import java.util.HashMap;

public enum ProductType {
    EGG, FLOUR, GRASS, MILK, WOOL, WATER, COOKIE, CAKE, EGG_POWDER, FABRIC, PLUME, CARNIVAL_DRESS, SEWING;

    public static Product getProduct(ProductType productType, double x, double y) {
        Product result = null;
        switch (productType) {
            case EGG:
                result = new Egg(x, y);
                break;
            case MILK:
                result = new Milk(x, y);
                break;
            case FLOUR:
                result = new Flour(x, y);
                break;
            case GRASS:
                result = new Grass(x, y);
                break;
            case WOOL:
                result = new Wool(x, y);
                break;
            case WATER:
                result = new Water(x, y);
                break;
            case COOKIE:
                result = new Cookie(x, y);
                break;
            case CAKE:
                result = new Cake(x, y);
                break;
            case EGG_POWDER:
                result = new EggPowder(x, y);
                break;
            case FABRIC:
                result = new Fabric(x, y);
                break;
            case PLUME:
                result = new Plume(x, y);
                break;
            case CARNIVAL_DRESS:
                result = new CarnnivalDress(x, y);
                break;
            case SEWING:
                result = new Sewing(x, y);
                break;
            // TODO: 12/31/2018 complete this shit
            default:
                result = null;
                break;
        }

        return result;
    }

    public static HashMap<ProductType, Integer> changeToHashMap(Product... products) {
        HashMap<ProductType, Integer> hashMap = new HashMap();
        ArrayList<ProductType> arrayList = new ArrayList<>();
        for (Product product : products) {
            if (arrayList.contains(product.getProductType())) {
                hashMap.replace(product.getProductType(), hashMap.get(product.getProductType()) + 1);
            } else {
                hashMap.put(product.getProductType(), 1);
                arrayList.add(product.getProductType());
            }

        }
        return hashMap;
    }
}
