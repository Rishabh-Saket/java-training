public class TMArrayListTest 
{
    public static void main(String[] args) 
    {
        TMList<Integer> list;
        list=new TMArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i+1);
        }
        System.out.println("Addded values");
        for(int i=0;i<list.size();i++) System.out.print(i+", ");
        list.clear();
        System.out.println(list.size());


        TMList<String> list2=new TMArrayList<>();
        for (int i = 0; i < 20; i++) {
            list2.add("Item"+(i+1));
        }
        for(int i=0;i<list2.size();i++) System.out.print(list2.get(i)+", ");
    }
}
