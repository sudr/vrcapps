package org.vrc.data.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "program")
public class Program
{
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    private String organization;
    
    private String name;
    
    private String description;
    
    private String address;
    
    private String phone;
    
    private String cost;
    
    private String website;
    
    private String hours;
    
    @Embedded
    private Eligibility eligibility;
    
    @Version
    private Long version;
    
    public Program()
    {
    }
    
    public Program(Long id, Category category)
    {
        this.id = id;
        this.category = category;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public Category getCategory()
    {
        return category;
    }
    
    public void setCategory(Category category)
    {
        this.category = category;
    }
    
    public String getOrganization()
    {
        return organization;
    }
    
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getCost()
    {
        return cost;
    }
    
    public void setCost(String cost)
    {
        this.cost = cost;
    }
    
    public String getWebsite()
    {
        return website;
    }
    
    public void setWebsite(String website)
    {
        this.website = website;
    }
    
    public String getHours()
    {
        return hours;
    }
    
    public void setHours(String hours)
    {
        this.hours = hours;
    }
    
    public Eligibility getEligibility()
    {
        return eligibility;
    }
    
    public void setEligibility(Eligibility eligibility)
    {
        this.eligibility = eligibility;
    }
    
    public Long getVersion()
    {
        return version;
    }
    
    public void setVersion(Long version)
    {
        this.version = version;
    }
    
}
