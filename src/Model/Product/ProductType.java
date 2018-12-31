package src.Model.Product;

public enum ProductType {
    EGG, FLOUR, GRASS, MILK, WOOL, WATER;

    public Product getProduct(ProductType productType, double x, double y) {
        Product result = null;
        switch (productType) {
            case EGG: result = new Egg(x, y);
                break;
            // TODO: 12/31/2018 complete this shit

            default: break;
        }

        return result;
    }
}
