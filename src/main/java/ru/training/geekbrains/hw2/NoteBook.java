package ru.training.geekbrains.hw2;

public class NoteBook implements Comparable<NoteBook> {
    private final Model model;
    private final int ram;
    private final int price;

    public NoteBook(Model model, int ram, int price) {
        this.model = model;
        this.ram = ram;
        this.price = price;
    }

    @Override
    public int compareTo(NoteBook o) {
        if (this.price == o.price) {
            if (this.ram == o.ram) {
                return model.compareTo(o.model);
            } else {
                return this.ram - o.ram;
            }
        }
        return this.price - o.price;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "price=" + price +
                ", ram=" + ram +
                ", model=" + model +
                "}\n";
    }
}
