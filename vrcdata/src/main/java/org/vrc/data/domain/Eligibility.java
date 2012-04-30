package org.vrc.data.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Eligibility
{
    private String note;
    
    private boolean veteran;
    
    private boolean disability;
    
    private String age;
    
    private String gender;
    
    public String getNote()
    {
        return note;
    }
    
    public void setNote(String note)
    {
        this.note = note;
    }
    
    public boolean isVeteran()
    {
        return veteran;
    }
    
    public void setVeteran(boolean veteran)
    {
        this.veteran = veteran;
    }
    
    public boolean isDisability()
    {
        return disability;
    }
    
    public void setDisability(boolean disability)
    {
        this.disability = disability;
    }
    
    public String getAge()
    {
        return age;
    }
    
    public void setAge(String age)
    {
        this.age = age;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
}
