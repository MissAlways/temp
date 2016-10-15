package bean;

/**
 *
 * @author MissAlways
 */
public class Item {

    private int itemId;
    private String name;
    private String type;
    private String description;
    private int attack;
    private int armor;

    public Item(int itemId, String name, String type, String description, int attack) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.attack = attack;
    }

    public Item(String name, String type, String description, int armor) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.armor = armor;
    }

    public Item(int itemId, String name, String type, String description) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Item() {
        itemId = 0;
        name = "";
        type = "";
        description = "";
        attack = 0;
        armor = 0;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", name=" + name + ", type=" + type + ", description=" + description + ", attack=" + attack + ", armor=" + armor + '}';
    }

}
