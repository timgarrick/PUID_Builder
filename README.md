# PUID_Builder
PUID Builder
PUID (Personal Unique ID) name is a unique name for a user. Consists of the users full name, first initial of first name and 3 randomly 
assigned digits. Total PUID name cannot exceed 20 characters. PUID name must be unique.

PUID number is a sequential unique LONG starting at 2
Surname and Firstname are users first name(s) and second name
Created date is when the PUID was initially generated
Modified date is when the PUID was last modified. Initially set as null

This is a model of a real world PUID database, project aims to model the following constraints:
  PUID number is generated sequentially, unique and not null.
  PUID name generated is always unique, not null. Number sequence doesn't matter, can be sequential.
  PUID name cannot exceed 20 characters. If this is the case, surname is trimmed down.
   
Project aims to resolve the following real world issue:
  Common surnames such as " Smith" and "Jones" with common first names (Cxxx, Axxxx etc) are limited to 899 users. For example JonesC100 to JonesC999.
  As PUIDs are never deleted, just set as obsolete, this limit can be reached in a real world scenario.
  After this limit, the database continues to add users but does not generate a unique PUID name and needs to be manually amended via SQL.
  
  

  
