package com.external.service.demo.controller;

import com.external.service.demo.model.JudicialRecordsDto;
import com.external.service.demo.model.Lead;
import com.external.service.demo.model.LeadDto;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Slf4j
@RestController
@RequestMapping( value = "/api/v1/",
                 consumes = { APPLICATION_JSON_VALUE },
                 produces = { APPLICATION_JSON_VALUE } )
public class ExternalController
{
    private static final EasyRandom GENERATOR = new EasyRandom();

    Logger logger = Logger.getLogger( ExternalController.class.getName() );


    @GetMapping( "judicial-registry/{leadId}" )
    public @ResponseBody
    JudicialRecordsDto getJudicialRecords( @PathVariable( "leadId" ) final int leadId )
    {
        logger.info( "Processing in Judicial System... ID: " + leadId );
        final boolean shouldHaveJudicialRecords = ( (int) ( Math.random() * 10 ) ) < 1;

        if ( shouldHaveJudicialRecords )
        {
            JudicialRecordsDto judicialRecordsDto = new JudicialRecordsDto( leadId, true );
            logger.info( "sending response [HAS JUDICIAL RECORDS]: " + judicialRecordsDto.toString() );
            return judicialRecordsDto;
        }

        JudicialRecordsDto judicialRecordsDto = new JudicialRecordsDto( leadId, false );
        logger.info( "sending response [HAS NOT JUDICIAL RECORDS]: " + judicialRecordsDto.toString() );
        return judicialRecordsDto;
    }


    @PostMapping( "national-registry/findLead" )
    public @ResponseBody
    LeadDto getLeadFromNationalSystem( @RequestBody final Lead lead )
    {
        logger.info( "Processing in National System... ID: " + lead.getIdNumber() );
        final boolean shouldReturnTheSameObject = ( (int) ( Math.random() * 10 ) ) > 2;

        if ( !shouldReturnTheSameObject )
        {

            LeadDto leadDto = new LeadDto( lead.getIdNumber(),
                                           GENERATOR.nextObject( LocalDate.class ),
                                           GENERATOR.nextObject( String.class ),
                                           GENERATOR.nextObject( String.class ),
                                           GENERATOR.nextObject( String.class ) + "@addi.com" );
            logger.info( "sending response [LEAD DOES NOT MATCH]: " + leadDto.toString() );
            return leadDto;
        }

        LeadDto leadDto = new LeadDto( lead.getIdNumber(),
                                       lead.getBirthDate(),
                                       lead.getFirstName(),
                                       lead.getLastName(),
                                       lead.getEmail() );
        logger.info( "sending response [LEAD MATCHES]: " + leadDto.toString() );
        return leadDto;
    }
}
