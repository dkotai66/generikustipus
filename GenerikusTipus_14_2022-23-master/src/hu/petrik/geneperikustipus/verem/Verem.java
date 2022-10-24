package hu.petrik.geneperikustipus.verem;

public class Verem <T extends Object>{
    private int stackSize;
    private T[] stackArray;
    private int top;

    public Verem(int meret){
        this.stackSize = meret;
        this.stackArray = (T[]) new Object[stackSize];
        this.top = 1;
    }

    public void push(T belepes) throws Exception{
        if(this.isFull()){
            System.out.println("A verem tele");
            increaseStackCapacity();
        }
        System.out.println(belepes+"Az elem hozzáadva");
        this.stackArray[++top]=belepes;
    }

    public T pop() throws Exception{
        if(this.isEmpty()){
            System.out.println("A verem üres");
        }
        T belepes=this.stackArray[top--];
        System.out.println(belepes+"Elem eltávolítva");
        return belepes;
    }

    public T top(){
        return stackArray[top];
    }

    public boolean isFull(){
        return (top == stackSize-1);
    }

    public boolean isEmpty(){
        return (top==1);
    }

    //public T empty{
    //
    //}

    private void increaseStackCapacity(){
        T[] newStack =(T[]) new Object [this.stackSize = 2];
        for (int i = 0; i<stackSize; i++){
            newStack[i] = this.stackArray[i];
        }
        this.stackArray = newStack;
        this.stackSize = this.stackSize+2;
    }

}
