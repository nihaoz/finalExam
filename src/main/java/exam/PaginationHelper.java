package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {

    /**
     * 定义两个私有成员变量分别来接受构造函数传进的参数
     */
    private List<I> collection;
    private int itemsPerPage;

    /**
     * 构造函数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        //构造函数进行初始化操作
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        int cntAllElem;
        if (collection.size() == 0) {
            throw new RuntimeException("个数为0");
        }
        //通过集合size()获取个数直接返回即可
        cntAllElem = collection.size();
        return cntAllElem;
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        int cntAllPage;
        //屏蔽原函数的的结构
        if (false) {
            throw new RuntimeException("源代码预留");
        }
        /**
        * 通过总条数对每页个数取余，判断是否分页条数有剩余，有剩余则多增加1个页码
         * 如果等于0    ====> 则说明总条数与分页条数刚好填满每个页面
         * 如果不等于0  ====> 则总条数/每页个数 + 1
         */
        if (itemCount() % itemsPerPage == 0) {
            cntAllPage = itemCount() / itemsPerPage;
        } else {
            cntAllPage = itemCount() / itemsPerPage + 1;
        }
        return cntAllPage;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        int cntCurrElem;
        /**
        *   index从0开始，分页起始编号从1开始，进行分页处理，分页公式：当前起始位置 = 总个数 - 索引*每页个数
        * */
        if (pageIndex < pageCount()) {
            if ((pageIndex + 1) * itemsPerPage > itemCount()) {
                cntCurrElem = itemCount() - (pageIndex) * itemsPerPage;
            } else {
                cntCurrElem = itemsPerPage;
            }
        } else {
            cntCurrElem = -1;
        }
        return cntCurrElem;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        int itemPageIndex;
        /**
        *   进行容错机制处理，当索引为0或者索引值大于总分页条数的话则返回-1
        */
        if (itemIndex < 0 || itemIndex > itemCount()) {
            itemPageIndex = -1;
        } else {
            if (itemIndex / itemsPerPage == 0) {
                itemPageIndex = itemIndex / itemsPerPage;
            } else {
                itemPageIndex = itemIndex / itemsPerPage;
            }
        }
        return itemPageIndex;
    }
}