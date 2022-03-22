/*
    枚舉類:
        1.當一個類的物件是限定的,確定的。那此類就被稱為枚舉類。
        2.當需要定義一組常量時,強烈建議使用枚舉類。
        3.如果枚舉類中只有一個物件,那可以用單例模式實現

        如何定義枚舉類:
            方式一:JDK1.5之前需要自定義枚舉類
            方式二:JDK 1.5 新增的 enum 關鍵字用於定義枚舉類


        Enum類的常用方法:
             values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
             valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
             toString()：返回当前枚举类对象常量的名称

        Enum類實現接口時須注意的情況:
            若需要每個枚舉值在調用實現的接口方法呈現出不同的行為方式,則可以讓每個枚舉值分別來實現該方法

 */

public class EnumIntro {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        System.out.println(Status.FREE);

        System.out.println("*****************values()***************");

        //Enum.values方法
        Status[] values = Status.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("*****************valueOf()***************");

        //Enum.valueOf方法
        Status Free = Status.valueOf("FREE");
        System.out.println(Free);
    }
}


//自訂義枚舉類
class Season{
    //1.聲明Season物件的屬性
    private final String seasonName;
    private  final String seasonDesc;


    //2.私有化構造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供當前枚舉類的多個物件
    public static final Season SPRING = new Season("春","春暖花開");
    public static final Season SUMMER = new Season("夏","夏日炎炎");
    public static final Season AUTUMN = new Season("秋","秋高氣爽");
    public static final Season WINTER = new Season("冬","白雪皚皚");

    //4.其他訴求

    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface Info{
    void show();
}

//Enum定義枚舉類
enum Status implements Info{
    //1.提供枚舉類的物件,各物件間用逗號隔開。
    FREE("FREE"){
        @Override
        public void show() {
            System.out.println("他很閒");
        }
    },
    BUSY("BUSY"){
        @Override
        public void show() {
            System.out.println("他很忙");
        }
    },
    VOCATION("VOCATION"){
        @Override
        public void show() {
            System.out.println("他在放假");
        }
    };

    //2.聲明屬性
    private final String statusNum;

    //3.私有化構造器
    private Status(String statusNum) {
        this.statusNum = statusNum;
    }

    //4.其他訴求

    public String getStatusNum() {
        return statusNum;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusNum='" + statusNum + '\'' +
                '}';
    }


    @Override
    public void show() {
        System.out.println("顯示員工的狀態");
    }
}
