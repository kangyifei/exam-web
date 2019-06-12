package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;
    private int itemsCount;
    private int pageCount;
    private boolean oneMorePage;
    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection=collection;
        this.itemsPerPage=itemsPerPage;
        this.itemsCount=collection.size();
        int pageCount=this.itemsCount/itemsPerPage;
        int morePage=this.itemsCount%itemsPerPage;
        if(morePage!=0){
            this.pageCount=pageCount+1;
            this.oneMorePage=true;
        }else {
            this.pageCount=pageCount;
            this.oneMorePage=false;
        }
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return this.itemsCount;
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        return this.pageCount;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex>pageCount-1 || pageIndex<0){
            return -1;
        }else {
            if(oneMorePage){
                if(pageIndex==pageCount-1){
                    return itemsCount-(pageCount-1)*itemsPerPage;
                }
                else {
                    return itemsPerPage;
                }
            }
            else {
                return itemsPerPage;
            }
        }
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex>itemsCount||itemIndex<1){
            return -1;
        }
        return (itemIndex-1)/itemsPerPage;
    }
}