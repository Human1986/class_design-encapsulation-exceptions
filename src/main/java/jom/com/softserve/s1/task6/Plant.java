package jom.com.softserve.s1.task6;

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

    public static Plant tryCreatePlant(String type, String color, String name) {
        Plant plant;
        try {
            plant = new Plant(type, color, name);
        } catch (TypeException e) {
            try {
                plant = new Plant("ORDINARY", color, name);
            } catch (ColorException exception) {
                try {
                    plant = new Plant(type, "RED", name);

                } catch (ColorException | TypeException ex) {
                    try {
                        plant = new Plant("ORDINARY", "Red", name);

                    } catch (Exception exc) {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (TypeException ex) {
                throw new IllegalArgumentException(ex);
            }
        } catch (ColorException e) {
            try {
                plant = new Plant(type, "RED", name);
            } catch (TypeException te) {
                try {
                    plant = new Plant("ORDINARY", "Red", name);
                } catch (Exception exc) {
                    throw new IllegalArgumentException(exc);
                }
            } catch (ColorException ex) {
                throw new IllegalArgumentException(ex);
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }

        return plant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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


