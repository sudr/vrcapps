package org.vrc.data.script

import org.apache.commons.lang3.builder.HashCodeBuilder;

class Organization
{

    def id
    def name
    
    Organization(name) {
        this.name = name
    }
    
    Organization(id, name) {
        this(name)
        this.id = id
    }
    
    @Override
    public boolean equals(Object obj)
    {
        def other = (Organization) obj
        return name.equals(other.name)
    }
    
    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17,37)
                    .append(this.name)
                    .toHashCode()
    }    
}
