package src.GUI.Menu;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Menu extends VBox {
    MenuFrame menuFrame;
    private Menu parent;
    private Group root;
    String name;
    Text text;
    int current = 0;
    protected Menu () {
        setSpacing(10);
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP){
                if (current > 0) {
                    getMenuItem(current).setActive(false);
                    getMenuItem(--current).setActive(true);
                }
            }
            if (event.getCode() == KeyCode.DOWN){
                if (current+1 < menuSize()){
                    getMenuItem(current).setActive(false);
                    getMenuItem(++current).setActive(true);
                }
            }
            getMenuItem(current).requestFocus();
        });
        this.setAlignment(Pos.CENTER);

        text = new Text();
        text.setFont(new Font("Snickles", 40));
        text.setFill(Color.BLACK);
        getChildren().add(text);

        MenuItem backItem = new MenuItem("Back", this);
        backItem.setActive(true);
        backItem.setGoesTo(()->{exitBack();});
        getChildren().add(backItem);

        menuFrame = new MenuFrame(this);
    }

    public Menu (String name){
        this();
        this.name = name;
        text.setText(name);
        parent = null;
    }

    public Menu (String name, Group root) {
        this(name);
        this.root = root;
    }

    public Menu (String name, Group root, Menu parent){
        this(name, root);
        this.parent = parent;
    }

    public boolean hasTitle(){
        return getChildren().contains(text);
    }

    public int menuSize(){
        return getChildren().size()-(hasTitle() ? 1 : 0);
    }

    public MenuItem getMenuItem(int idx){
        return (MenuItem)getChildren().get(idx+(hasTitle() ? 1 : 0));
    }

    public Group getRoot(){
        if (root != null) return root;
        if (parent == null) return null;
        return root = parent.getRoot();
    }

    public void add(String name){
        getChildren().add(new MenuItem(name, this));
        adjust();
    }

    public void addAll(String... name){
        for (int i = 0; i < name.length; i++)
            add(name[i]);
        adjust();
    }

    void setRoot(Group root){
        this.root = root;
    }

    void setParent(Menu par){
        this.parent = par;
    }

    private void exit(){
        if (isActive())
            getRoot().getChildren().remove(menuFrame);
    }

    public void start(){
        if (parent != null)
            parent.exit();
        else
            getRoot().Pause(this);
        if (getRoot() != null) {
            getRoot().getChildren().add(menuFrame);
            if (menuSize() > 0)
                getMenuItem(current).requestFocus();
            getRoot().setActiveMenu(this);
        }
    }

    public void exitBack(){
        System.out.println(":D");
        exit();
        if (parent != null)
            parent.start();
        else if (getRoot() != null)
            getRoot().Play();
    }

    private void add (MenuItem item){
        item.setParent(this);
        getChildren().add(item);
    }

    public void addAll(MenuItem... items){
        for (MenuItem item : items)
            add(item);
        adjust();
    }

    public boolean isActive(){
        return getRoot() != null && getRoot().getChildren().contains(menuFrame);
    }

    protected void adjust(){
        text.setFont(new Font("Snickles", 100 - 10*Math.sqrt(text.getText().length())));
        double width = text.getFont().getSize()*text.getText().length()/2, height = 0;
        for (int i = 0; i < menuSize(); i++) {
            getMenuItem(i).text.setFont(new Font("Snickles", Math.min(getMenuItem(i).text.getFont().getSize(), 300/menuSize())));
            height += getMenuItem(i).getHeight() * 2;
            double w = getMenuItem(i).getWidth() * 2;
            if (w > width) width = w;
        }
        menuFrame.setLayoutX(960/2 - width/2);
        menuFrame.setLayoutY(712.5/2 - height/2);
        menuFrame.frame.setWidth(width);
        menuFrame.frame.setHeight(height);
    }
}
