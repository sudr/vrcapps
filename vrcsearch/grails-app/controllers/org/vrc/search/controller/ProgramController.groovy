package org.vrc.search.controller

import org.vrc.search.domain.Program

import grails.converters.JSON


class ProgramController {

    def index() { }
    
    def search() {
        def name = params.name
        def organization = params.organization
        
        params.each{
            key, value -> print key;
        }
        
        def programs
        if (name?.trim()) {
            programs = Program.findAllByNameLike('%' + name + '%')
        } else if (organization?.trim()) {
            programs = Program.findAllByOrganizationLike("%" + organization + "%")
        } else if (hasQueryParams(params)) {
            def genderParm = scrub(params.gender)
            def veteranParm = scrub(params.veteran)
            // veteran
            // age
            // activeDuty
            // yearsserved
            // disabled
            def query = Program.where {
                if (genderParm) { gender == genderParm };
                if (veteranParm) { veteran == veteranParm };
            };
            programs = query.findAll()
            
        } else {
            programs = Program.list()
        }
        render programs as JSON
    }
    
    boolean hasQueryParams(params) {
        for (String key : params.keySet())
        {
           if (! key.equalsIgnoreCase("action") && ! key.equalsIgnoreCase("controller")) {
               return true;
           }
        }
        return false;
    }
    
    String scrub(value) {
        value?.trim()
    }
}
