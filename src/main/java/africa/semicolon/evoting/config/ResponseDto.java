package africa.semicolon.evoting.config;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
    private Long page, per_page, total, total_pages;
    private List<University> data = new ArrayList();

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPer_page() {
        return per_page;
    }

    public void setPer_page(Long per_page) {
        this.per_page = per_page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Long total_pages) {
        this.total_pages = total_pages;
    }

    public List<University> getData() {
        return data;
    }

    public void setData(List<University> data) {
        this.data = data;
    }
}
