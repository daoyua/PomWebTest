package com.test.server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "cst_customer", schema = "test", catalog = "")
public class CstCustomerEntity {
    private int customerId;
    private String custName;
    private String custSource;
    private String custLeave;
    private String custIndustry;
    private String custPhone;
    private String custMobile;

    @Id
    @Column(name = "customerId")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "cust_source")
    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    @Basic
    @Column(name = "cust_leave")
    public String getCustLeave() {
        return custLeave;
    }

    public void setCustLeave(String custLeave) {
        this.custLeave = custLeave;
    }

    @Basic
    @Column(name = "cust_industry")
    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    @Basic
    @Column(name = "cust_phone")
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Basic
    @Column(name = "cust_mobile")
    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CstCustomerEntity that = (CstCustomerEntity) o;

        if (customerId != that.customerId) return false;
        if (custName != null ? !custName.equals(that.custName) : that.custName != null) return false;
        if (custSource != null ? !custSource.equals(that.custSource) : that.custSource != null) return false;
        if (custLeave != null ? !custLeave.equals(that.custLeave) : that.custLeave != null) return false;
        if (custIndustry != null ? !custIndustry.equals(that.custIndustry) : that.custIndustry != null) return false;
        if (custPhone != null ? !custPhone.equals(that.custPhone) : that.custPhone != null) return false;
        if (custMobile != null ? !custMobile.equals(that.custMobile) : that.custMobile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        result = 31 * result + (custSource != null ? custSource.hashCode() : 0);
        result = 31 * result + (custLeave != null ? custLeave.hashCode() : 0);
        result = 31 * result + (custIndustry != null ? custIndustry.hashCode() : 0);
        result = 31 * result + (custPhone != null ? custPhone.hashCode() : 0);
        result = 31 * result + (custMobile != null ? custMobile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CstCustomerEntity{" +
                "customerId=" + customerId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLeave='" + custLeave + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }
}
