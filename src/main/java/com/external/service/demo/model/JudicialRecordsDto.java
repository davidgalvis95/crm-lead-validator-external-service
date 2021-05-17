package com.external.service.demo.model;

public class JudicialRecordsDto
{
    private Integer id;

    private Boolean hasJudicialRecords;


    public void setId( final Integer id )
    {
        this.id = id;
    }


    public void setHasJudicialRecords( final Boolean hasJudicialRecords )
    {
        this.hasJudicialRecords = hasJudicialRecords;
    }


    public Integer getId()
    {
        return id;
    }


    public Boolean getHasJudicialRecords()
    {
        return hasJudicialRecords;
    }


    public JudicialRecordsDto( final Integer id,
                               final Boolean hasJudicialRecords )
    {
        this.id = id;
        this.hasJudicialRecords = hasJudicialRecords;
    }


    @Override
    public String toString()
    {
        return "JudicialRecordsDto{" +
               "id=" + id +
               ", hasJudicialRecords=" + hasJudicialRecords +
               '}';
    }
}
