package com.money.manager.ex.investment;

import android.content.Context;

import com.money.manager.ex.R;
import com.money.manager.ex.domainmodel.StockHistory;
import com.money.manager.ex.database.Dataset;
import com.money.manager.ex.database.DatasetType;
import com.money.manager.ex.database.TableStock;
import com.money.manager.ex.utils.RawFileUtils;

/**
 * Watchlist query.
 */
public class WatchlistDataset
    extends Dataset {

    public WatchlistDataset(Context context) {
        super(RawFileUtils.getRawAsString(context, R.raw.query_watchlist), DatasetType.QUERY,
                "watchlist");

        mContext = context;
    }

    private Context mContext;

    @Override
    public String[] getAllColumns() {
        return new String[] {
                TableStock.STOCKID + " AS _id",
                TableStock.STOCKID,
                TableStock.HELDAT,
                TableStock.STOCKNAME,
                TableStock.SYMBOL,
                StockHistory.DATE,
                StockHistory.VALUE
        };
    }

    public String getWatchlistSqlQuery() {
        String result = RawFileUtils.getRawAsString(mContext, R.raw.query_watchlist);
        return result;
    }

}
