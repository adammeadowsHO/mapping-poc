# Lambda 
Install SAM CLI and docker.

In the .run folder, there is an example runner for Intellij
 
# Soap
To generate the wsdl. Run the following 

```
curl -v https://core-report-and-manage-intelligence-ho-it-dev1-i-ie-ims.np.ebsa.homeoffice.gov.uk/lagan/schema/FLService.wsdl > FLService.wsdl
```
Then build the application. `./gradlew build`


### Optional for a succesful build

(You may need to remove the following from the file for it to work)
```
 <xs:annotation>
    <xs:documentation>
         Values: task
    </xs:documentation>
</xs:annotation>
```
and
```
<xs:annotation>
    <xs:documentation>
        Allow use of 0 for ObjectType to indicate that the associated
        object is to be cleared, not set.
    </xs:documentation>
</xs:annotation>
```
Unsure why currently