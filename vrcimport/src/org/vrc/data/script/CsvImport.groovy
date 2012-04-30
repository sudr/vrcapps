package org.vrc.data.script

@Grab('com.xlson.groovycsv:groovycsv:1.0')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.json.StringEscapeUtils;

import org.apache.commons.lang3.text.WordUtils;

import org.vrc.data.domain.Program
import org.vrc.data.domain.Category
import org.vrc.data.domain.Eligibility

class CsvImport {
    def categories = new ArrayList()
    def organizations = new ArrayList()
    def programs = new ArrayList()
    
    public static void main(String[] args) {
        def csvImport = new CsvImport()
        csvImport.process()
    }

    void process() {    
        def csv = (new File('./data/assistance_data.csv')).text
        def data = parseCsv(csv)
        
        for(line in data) {
            def category = addToCategoriesIfNotExists(scrub("$line.Category"))
            //def organization = addToOrganizationsIfNotExists(scrub("$line.Organization"))

            def program = new Program(programs.size() + 1, category)
            
            program.organization = scrub("$line.Organization")
            program.phone = scrub("$line.Phone")
            program.address = scrub("$line.Address")
            program.website = StringEscapeUtils.escapeJavaScript("$line.Website".trim().toLowerCase())
            program.hours = StringEscapeUtils.escapeJavaScript("$line.Hours".trim())
            program.name = scrub("$line.ProgramName")
            program.description = StringEscapeUtils.escapeJavaScript("$line.ProgramDescription".trim())
            program.cost = StringEscapeUtils.escapeJavaScript("$line.Cost".trim())
            
            def eligibility = new Eligibility()
            eligibility.note = StringEscapeUtils.escapeJavaScript("$line.EligibilityNotes".trim())
            eligibility.veteran = scrub("$line.Veteran").equalsIgnoreCase("y") ? true : false
            eligibility.disability = scrub("$line.Disability").equalsIgnoreCase("y") ? true : false
            eligibility.age = scrub("$line.Age")
            eligibility.gender = scrub("$line.Gender")
            
            program.eligibility = eligibility
            
            programs.add(program)
        }
     
        spitSql()
        
    }
    
    def spitSql() {
        categories.each {
            println "insert into category(name) values ('$it.name');"
        }
        
        programs.each {
            println "insert into program(category_id,organization,name,description,address,phone,cost,website,hours,note,veteran,disability,age,gender) values ('$it.category.id','$it.organization','$it.name','$it.description','$it.address','$it.phone','$it.cost','$it.website','$it.hours','$it.eligibility.note','$it.eligibility.veteran','$it.eligibility.disability','$it.eligibility.age','$it.eligibility.gender');"
            /*it.eligibilities.each {
                println "insert into eligibility(note,veteran,disability,age,gender,program_id) values('$it.note','$it.veteran','$it.disability','$it.age','$it.gender','$it.program.id');"
            }*/
        }
    }
    
    String scrub(itemName) {
        def name = itemName.trim()
        return WordUtils.capitalize(StringEscapeUtils.escapeJavaScript(name.toLowerCase()))
    }
    
    Category addToCategoriesIfNotExists(name) {
        def category = new Category(name)
        if ( categoryExists(category) ) {
            category = findCategory(category)
        } else {
            category = new Category(categories.size() + 1, name)
            categories.add(category)
        }
        
        return category
    }
    
    boolean categoryExists(category) {
        for (Category cat : categories)
        {
            if (cat.name.equalsIgnoreCase(category.name)) {
                return true;
            }
        }
        return false;
    }
    
    Category findCategory(category) {
        for (Category item : categories)
        {
            if (item.name.equalsIgnoreCase(category.name)) {
                return item
            }
        }
        return null;
    }
    
    
    /*void addToOrganizationsIfNotExists(name) {
        def organization = new Organization(name)
        if ( organizationExists(organization) ) {
            organization = findOrganization(organization)
        } else {
            organization = new Organization(organizations.size() + 1, name)
        }
        
        organizations.add(organization)
    }
    
    boolean organizationExists(organization) {
        return organizations.contains(organization);
    }
    
    Organization findOrganization(organization) {
        for (Organization item : organization)
        {
            if (item.equals(organization)) {
                return item
            }
        }
        return null;
    }*/
        
}
