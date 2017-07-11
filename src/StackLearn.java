import java.util.Scanner;

/**
 * Created by 时光与你 on 2017/7/11.
 */
/*
！！！Java常用算法之——数据结构之——堆栈！！！
 */
/*
定义栈数据
 */
class DATA3{
    String namel;
    int age;
}
/*
定义栈
 */
class StackType{
    static final int MAXLEN = 50;
    DATA3[] data = new DATA3[MAXLEN + 1];
    int top;

    /*
初始化栈
 */
    StackType STInit(){
        StackType p;
         if ((p = new StackType())!= null){
             p.top = 0;
             return p;
         }
         return null;
    }

    /*
    判断栈是否为空
     */
    boolean STIsEmpty(StackType s){
        boolean t;
        t = (s.top == 0);
        return t;
    }

    /*
    判断栈是否已满
     */
    boolean STIsFull(StackType s){
        boolean t;
        t = (s.top == MAXLEN);
        return t;
    }

    /*
    请空栈
     */
    void STClear(StackType s){
        s.top = 0;
    }

    /*
    释放栈所占空间
     */
    void STFree(StackType s){
        if (s != null){
            s = null;
        }
    }

    /*
    入栈操作
     */
    int PushSt(StackType s, DATA3 data){
        if (s.top + 1 > MAXLEN){
            System.out.println("栈溢出！\n");
            return 0;
        }
        s.data[++s.top] = data;
        return 1;
    }

    /*
    出栈操作
     */
    DATA3 PopST(StackType s){
        if (s.top == 0){
            System.out.println("栈为空\n");
        }
        return s.data[s.top--];
    }

    /*
    读取栈顶数据
     */
    DATA3 PeekST(StackType s){
        if (s.top == 0){
            System.out.println("栈为空\n");
            System.exit(0);
        }
        return s.data[s.top];
    }
}

public class StackLearn {
    public static void main(String[] args) {
        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        StackType stack = st.STInit();//初始化后的栈
        Scanner input = new Scanner(System.in);
        System.out.println("入栈操作！\n");
        System.out.println("输入姓名 年龄进行入栈操作：");
        do {
            DATA3 data = new DATA3();
            data.namel = input.next();

            if (data.namel.equals("0")){
                break;
            }
            else {
                data.age = input.nextInt();
                st.PushSt(stack, data);
            }
        }while (true);
        String temp = "1";
        System.out.println("出栈操作：按任意非零键进行出栈");
        temp = input.next();
        while (!temp.equals("0")){
            data1 = st.PopST(stack);
            System.out.println("出栈的数据是："+data1.namel+","+data1.age);
            temp = input.next();
        }
        System.out.println("测试结束！");
        st.STFree(st);
    }
}
