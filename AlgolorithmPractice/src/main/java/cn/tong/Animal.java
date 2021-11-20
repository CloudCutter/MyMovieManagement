package cn.tong;

abstract class Animal {
    public Animal(int n){
        System.out.println(n);
    }
    public String name;
    public static final String type = "哺乳动物";
    public void ear(){
        System.out.println("eat");
    }
    abstract void hangout();
}

