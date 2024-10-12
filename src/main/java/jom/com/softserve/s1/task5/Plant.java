package jom.com.softserve.s1.task5;




public class Plant {
    private Type type;
    private Color color;
    private String name;


    public Plant(String type, String color, String name) throws TypeException, ColorException {
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TypeException(type);
        }

        try {
            this.color = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ColorException(color);
        }

        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{" +
               "type: " + type + ", " +
               "color: " + color + ", " +
               "name: " + name +
               "}";
    }
}
enum Color {
    WHITE, RED, BLUE
}

enum Type {
    RARE, ORDINARY
}


class ColorException extends Exception {
    public ColorException(String color) {
        super("Invalid value " + color + " for field color");
    }
}

class TypeException extends Exception {
    public TypeException(String type) {
        super("Invalid value " + type + " for field type");
    }
}
