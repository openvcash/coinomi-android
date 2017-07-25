package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author xCore @ openvcash
 */
public class VcashMain extends PeerFamily {
    private VcashMain() {
        id = "vcash.main";

        addressHeader = 71;
        p2shHeader = 8;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 220;
        dumpedPrivateKeyHeader = 199;

        name = "Vcash";
        symbol = "XVC";
        uriScheme = "vcash";
        bip44Index = 0;
        unitExponent = 6;
        feeValue = value(500); // 0.0005XVC
        minNonDust = value(500); // 0.0005XVC
        softDustLimit = minNonDust;
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("Vcash Signed Message:\n");
    }

    private static VcashMain instance = new VcashMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
