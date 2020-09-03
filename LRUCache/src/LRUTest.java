public class LRUTest {
    public static void main(String [] args) {
        LRUCache l = new LRUCache(5);
        l.accessCache(1);
        l.updateCache(1, 24);
        l.accessCache(2);
        l.updateCache(2, 48);
        l.accessCache(3);
        l.updateCache(3, 36);
        l.accessCache(4);
        l.updateCache(4, 72);
        l.accessCache(5);
        l.updateCache(5, 12);
        l.displayCache();
        l.accessCache(1);
        l.displayCache();
        l.accessCache(6);
        l.updateCache(6, 96);
        l.displayCache();
        l.updateCache(4, 102);
        l.displayCache();
    }
}
