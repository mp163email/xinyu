package 枚举;

/**
 * 枚举中可以定义一个方法
 */
public enum OrderEnum {
    UnPay(0, "未支付") {
        public void print() {
            System.out.println("====未支付====");
        }
    },
    Payed(1, "已支付"){
        public void print() {
            System.out.println("====已支付====");
        }
    },
    Send(2, "已发货") {
        public void print() {
            System.out.println("====已发货====");
        }
    };

    public void print() {
        throw new IllegalArgumentException("枚举不合法");
    }

    OrderEnum (int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private int status;

    private String desc;

    public int getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }

    public static OrderEnum of (int status) {
        for (OrderEnum orderEnum : OrderEnum.values()) {
            if (orderEnum.getStatus() == status) {
                return orderEnum;
            }
        }
        return null;
    }

}
