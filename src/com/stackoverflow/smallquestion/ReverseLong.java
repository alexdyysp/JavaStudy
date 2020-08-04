package com.stackoverflow.smallquestion;

public class ReverseLong {

        public Long reverse(Long x) {
            Long rev = 0L;
            while (x != 0) {
                Long pop = x % 10;
                x /= 10;
                if (rev > Long.MAX_VALUE/10 || (rev == Long.MAX_VALUE / 10 && pop > 7)) return 0L;
                if (rev < Long.MIN_VALUE/10 || (rev == Long.MIN_VALUE / 10 && pop < -8)) return 0L;
                rev = rev * 10 + pop;
            }
            return rev;
        }


    public static void main(String[] args){
        ReverseLong r = new ReverseLong();
        System.out.println(r.reverse(98765432112L));
    }
}
