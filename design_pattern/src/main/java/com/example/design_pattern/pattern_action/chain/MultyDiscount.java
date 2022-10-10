package com.example.design_pattern.pattern_action.chain;

import com.example.design_pattern.pattern_action.strategy.Discount;

/**R
 * Created by Peter on 10/29 029.
 */
public abstract class MultyDiscount implements Discount {
    protected MultyDiscount nextMultyDiscount;

    public MultyDiscount(MultyDiscount nextMultyDiscount){
        this.nextMultyDiscount = nextMultyDiscount;
    }

    public int calculate(int money){
        if (this.nextMultyDiscount != null){
            return this.nextMultyDiscount.calculate(money);
        }
        return money;
    }

}
