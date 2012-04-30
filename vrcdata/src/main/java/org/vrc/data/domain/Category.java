package org.vrc.data.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name="category")
public class Category
{
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy="category")
    private List<Program> programs;
    
    @Version
    private Long version;
    
    public Category()
    {
    }

    public Category(String name)
    {
        this.name = name;
    }
    
    public Category(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public List<Program> getPrograms()
    {
        return programs;
    }

    public void setPrograms(List<Program> programs)
    {
        this.programs = programs;
    }

    public Long getVersion()
    {
        return version;
    }
    
    public void setVersion(Long version)
    {
        this.version = version;
    }
/*
    @Override
    public boolean equals(Object obj)
    {
        Category other = (Category) obj;
        return name.equals(other.name);
    }
    
    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17,37)
                    .append(this.name)
                    .toHashCode();
    }
*/
}
