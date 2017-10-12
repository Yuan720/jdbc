

public class MailSending {
    public static void main(String[] args) {
        liuhecai kb = new liuhecai();
        dutu sb = new dutu();
        for (int i = 1; i <= 500; i++) {
            int tep = sb.getdouzhu();
            int chuma = kb.chuma();
            int xiema = sb.xiema();
            kb.account = kb.account + tep;
            sb.account = sb.account - tep;
            if (chuma == xiema) {
                kb.account = kb.account - 40 * tep;
                sb.account = sb.account + 40 * tep;
                System.out.println("                         " + "第" + i + "次投注号" + xiema + "\n" + "开奖号" + chuma + "\n" + "中奖" + tep * 40 + "\n" + "赌徒账户余额:" + sb.account + "\n" + "庄家余额" + kb.account);
            } else
                System.out.println("第" + i + "次投注号" + xiema + "\n" + "开奖号" + chuma + "\n" + "亏损" + tep + "\n" + "赌徒账户余额:" + sb.account + "\n" + "庄家余额" + kb.account);
            if (kb.account <= 0 | sb.account <= 0) {
                System.out.println(kb.account > sb.account ? "赌徒破产了" + "\n" + "久赌必输啊" : "庄家破产了" + "\n" + "小赌改善生活,大赌发家致富");
                break;
            }
        }

    }
}

class liuhecai {
    int account = 100000;
    int tema;

    int chuma() {
        while ((tema = (int) (Math.random() * 49)) == 0)
            tema = (int) (Math.random() * 49);
        return tema;

    }


}


class dutu {
    int account = 100000;
    int duzhu;

    int getdouzhu() {
        while ((duzhu = (int) (Math.random() * 800)) == 0)
            duzhu = (int) (Math.random() * 8000);
        return duzhu;

    }

    int xiema() {
        int caima;
        while ((caima = (int) (Math.random() * 49)) == 0)
            caima = (int) (Math.random() * 49);
        return caima;
    }

}