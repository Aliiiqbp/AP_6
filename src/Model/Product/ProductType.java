package src.Model.Product;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

public enum ProductType {
    EGG, FLOUR, GRASS, MILK, WOOL, WATER, COOKIE, CAKE, EGGPOWDER, FABRIC, PLUME, CARNIVALDRESS, SEWING;

    public Product getProduct(ProductType productType, double x, double y) {
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
            case EGGPOWDER:
                result = new EggPowder(x, y);
                break;
            case FABRIC:
                result = new Fabric(x, y);
                break;
            case PLUME:
                result = new Plume(x, y);
                break;
            case CARNIVALDRESS:
                result = new CarnnivalDress(x, y);
                break;
            case SEWING:
                result = new Sewing(x, y);
                break;
        }
            // TODO: 12/31/2018 complete this shit
            case default:
                result = null;
                break;
        }

        return result;
    }
}
