package com.caue.kioski.interfaces;

import java.math.BigDecimal;

public interface TaxCalculator
{
    BigDecimal tax(BigDecimal amount);
}
