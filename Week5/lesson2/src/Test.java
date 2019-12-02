public class Test {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(5);

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class A {
    String a1;
}

class B extends A {
    String b1;
}
