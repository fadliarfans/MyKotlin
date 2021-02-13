public class coba2 {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // this is comment

        // tipe data dasar
        int a     = 10;
        String b  ="sapi";
        double c  = 8.9989d;
        char d    = 'g';
        boolean e = true;

        // final  konstanta
        final int f = 4343;

        //String bisa ditambah
        String g =" kambing";
        String h = b+g;

        // primitive = sudah ditentukan
        // Non primitive = Tipe non-primitif dibuat oleh programmer dan tidak ditentukan oleh Java
        // Non-primitive types can be used to call methods to perform certain operations, while primitive types cannot.
        // A primitive type has always a value, while non-primitive types can be null.
        // A primitive type starts with a lowercase letter, while non-primitive types starts with an uppercase letter.
        // The size of a primitive type depends on the data type, while non-primitive types have all the same size.

        // float diakhiri "f", sedangkan double diakhiri "d".
        float i = 8.43323f;

        // narrowing (penyempitan) Casting
        float j = 10.323f;
        int k   = (int) j;  // output 10

        // Widening (perluasan) Casting
        int l   = 3143;
        float m = l;        // output 3143.0

        //Operator Like C language
        int n,o=34,p=43;
        n = o+p-(o%p)+(o*(p/o)); // output 77

        

        // output = System.out.println(variabel atau text);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        System.out.println(p);





    }
}
