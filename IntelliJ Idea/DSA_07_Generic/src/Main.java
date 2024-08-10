//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Ví dụ 1:
        Dictionary<String, String> d1 = new Dictionary<>("Xin chào", "Hello");
        System.out.println(d1.toString());

        Dictionary<String, String>[] d2 = new Dictionary[10];
        d2[0] = new Dictionary<>("Xin chào", "Hello");
        d2[1] = new Dictionary<>("Goodbye", "Tạm biệt");

        for (int i = 0; i < d2.length; i++) {
            if(d2[i] != null)
            {
                System.out.println(d2[i].toString());
            }
            else
            {
                break;
            }
        }

        //Ví dụ 2:
        Dictionary<Integer, Character>[] bangMaAscii = new Dictionary[256];
        bangMaAscii[0] = new Dictionary<>(32, ' ');
        bangMaAscii[1] = new Dictionary<>(33, '!');

        for (int i = 0; i < bangMaAscii.length; i++) {
            if(bangMaAscii[i] != null)
            {
                System.out.println(bangMaAscii[i].toString());
            }
            else
            {
                break;
            }
        }

        //Ví dụ 3:

        Dictionary<Character, Integer>[] bangMaAscii1 = new Dictionary[256];
        bangMaAscii1[0] = new Dictionary<>(' ', 32);
        bangMaAscii1[1] = new Dictionary<>('!', 33);

        for (int i = 0; i < bangMaAscii1.length; i++) {
            if(bangMaAscii1[i] != null)
            {
                System.out.println(bangMaAscii1[i].toString());
            }
            else
            {
                break;
            }
        }

    }
}