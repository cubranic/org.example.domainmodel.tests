package org.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(DomainmodelInjectorProvider)
class DomainmodelGenerationTest {
    @Inject public TemporaryFolder temporaryFolder
    @Inject extension CompilationTestHelper        
    
    @Test
    def void empty() {
        '''
        entity foo {}
        '''.assertCompilesTo('''
        @SuppressWarnings("all")
        public class foo {
        }
        ''')
    }
    
    @Test
    def void exampleSimple() {
        '''
        package my.model {
            entity Address {
                street: String
                zip: String
                city: String
            }
        }
        '''.assertCompilesTo('''
        package my.model;
        
        @SuppressWarnings("all")
        public class Address {
          private String street;
          
          public String getStreet() {
            return this.street;
          }
          
          public void setStreet(final String street) {
            this.street = street;
          }
          
          private String zip;
          
          public String getZip() {
            return this.zip;
          }
          
          public void setZip(final String zip) {
            this.zip = zip;
          }
          
          private String city;
          
          public String getCity() {
            return this.city;
          }
          
          public void setCity(final String city) {
            this.city = city;
          }
        }
        ''')
    }
    
    @Test
    def void exampleOps() {
        '''
        import java.util.List
         
        package my.model {
         
            entity Person {
                name: String
                firstName: String
                friends: List<Person>
                op getFullName() : String {
                    return firstName + " " + name;
                }
                
                op getFriendsSortedByFullName() : List<Person> {
                    return friends.sortBy[ f | f.fullName ]
                }
            }
        }
        '''.assertCompilesTo('''
        package my.model;
        
        import java.util.List;
        import org.eclipse.xtext.xbase.lib.Functions.Function1;
        import org.eclipse.xtext.xbase.lib.IterableExtensions;
        
        @SuppressWarnings("all")
        public class Person {
          private String name;
          
          public String getName() {
            return this.name;
          }
          
          public void setName(final String name) {
            this.name = name;
          }
          
          private String firstName;
          
          public String getFirstName() {
            return this.firstName;
          }
          
          public void setFirstName(final String firstName) {
            this.firstName = firstName;
          }
          
          private List<Person> friends;
          
          public List<Person> getFriends() {
            return this.friends;
          }
          
          public void setFriends(final List<Person> friends) {
            this.friends = friends;
          }
          
          public String getFullName() {
            return ((this.firstName + " ") + this.name);
          }
          
          public List<Person> getFriendsSortedByFullName() {
            final Function1<Person, String> _function = new Function1<Person, String>() {
              public String apply(final Person f) {
                return f.getFullName();
              }
            };
            return IterableExtensions.<Person, String>sortBy(this.friends, _function);
          }
        }
        ''')
    }
    
    @Test
    def void loop() {
        '''
            import java.util.List
             
            package my.model {
             
                entity Person {
                    name: String
                    friends: List<Person>
                    op findFriend(Person name) : Person {
                        for (var int i = 0; i < friends.size; i++) {
                            val friend = friends.get(i)
                            if (friend.name.equals(name)) {
                                return friend
                            }
                        }
                        return null
                    }
                }
            }
         '''.assertCompilesTo('''
            package my.model;
            
            import java.util.List;
            
            @SuppressWarnings("all")
            public class Person {
              private String name;
              
              public String getName() {
                return this.name;
              }
              
              public void setName(final String name) {
                this.name = name;
              }
              
              private List<Person> friends;
              
              public List<Person> getFriends() {
                return this.friends;
              }
              
              public void setFriends(final List<Person> friends) {
                this.friends = friends;
              }
              
              public Person findFriend(final Person name) {
                for (int i = 0; (i < this.friends.size()); i++) {
                  {
                    final Person friend = this.friends.get(i);
                    boolean _equals = friend.name.equals(name);
                    if (_equals) {
                      return friend;
                    }
                  }
                }
                return null;
              }
            }
         ''')
    }
}