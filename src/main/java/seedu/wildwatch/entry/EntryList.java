package seedu.wildwatch.entry;

import seedu.wildwatch.operation.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;

public class EntryList {
    private static ArrayList<Entry> entries = new ArrayList<>(); //Keeps track of all Entry instances made

    public static ArrayList<Entry> getArray() {
        return entries;
    }

    public static int getArraySize() {
        return entries.size();
    }

    public static void addEntry(Entry entry) {
        entries.add(entry);
    }

    public static void deleteEntry(int numberInput){
        entries.remove(numberInput - 1);
    }

    public static Entry getEntry(int nthEntry) {
        return entries.get(nthEntry);
    }

    public static LocalDate getEntryDate(int nthEntry) {
        return getEntry(nthEntry).getDate();
    }

    public static String getEntrySpecies(int nthEntry) {
        return getEntry(nthEntry).getSpecies();
    }

    public static String getEntryName(int nthEntry) {
        return getEntry(nthEntry).getName();
    }

    public static String getEntryRemark(int nthEntry) {
        return getEntry(nthEntry).getRemark();
    }

    public static boolean isArrayEmpty() {
        return entries.isEmpty();
    }

    public static void saveEntry() {
        FileHandler.saver(entries);
    }
}
