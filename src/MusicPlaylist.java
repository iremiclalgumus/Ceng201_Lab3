public class MusicPlaylist {
    private SongNode head;
    private SongNode tail;
    private SongNode current;

    public MusicPlaylist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    public void addSong(String title) {
        SongNode newNode = new SongNode(title);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeSong(String title) {
        SongNode curr = head;
        while (curr != null && !curr.title.equals(title)) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        System.out.println("Removed: " + curr.title);

        if (curr == head && curr == tail) {
            head = null;
            tail = null;
            current = null;
        } else if (curr == head) {
            head = head.next;
            head.prev = null;
            if (current == curr) {
                current = head;
            }
        } else if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
            if (current == curr) {
                current = tail;
            }
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            if (current == curr) {
                current = curr.next;
            }
        }
    }

    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }

    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }

    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        }
    }

    public void displayPlaylist() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}