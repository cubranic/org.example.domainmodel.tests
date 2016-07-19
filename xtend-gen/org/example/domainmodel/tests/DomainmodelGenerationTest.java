package org.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.TemporaryFolder;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.example.domainmodel.tests.DomainmodelInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class DomainmodelGenerationTest {
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void empty() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity foo {}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class foo {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exampleSimple() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package my.model {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("entity Address {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("street: String");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("zip: String");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("city: String");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package my.model;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class Address {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String street;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getStreet() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.street;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setStreet(final String street) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.street = street;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String zip;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getZip() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.zip;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setZip(final String zip) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.zip = zip;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String city;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getCity() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.city;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setCity(final String city) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.city = city;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exampleOps() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append(" ");
      _builder.newLine();
      _builder.append("package my.model {");
      _builder.newLine();
      _builder.append(" ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("entity Person {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("name: String");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("firstName: String");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("friends: List<Person>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("op getFullName() : String {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return firstName + \" \" + name;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("op getFriendsSortedByFullName() : List<Person> {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return friends.sortBy[ f | f.fullName ]");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package my.model;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import java.util.List;");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class Person {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setName(final String name) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.name = name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String firstName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getFirstName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.firstName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setFirstName(final String firstName) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.firstName = firstName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private List<Person> friends;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public List<Person> getFriends() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.friends;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setFriends(final List<Person> friends) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.friends = friends;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getFullName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return ((this.firstName + \" \") + this.name);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public List<Person> getFriendsSortedByFullName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("final Function1<Person, String> _function = new Function1<Person, String>() {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("public String apply(final Person f) {");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("return f.getFullName();");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return IterableExtensions.<Person, String>sortBy(this.friends, _function);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void loop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append(" ");
      _builder.newLine();
      _builder.append("package my.model {");
      _builder.newLine();
      _builder.append(" ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("entity Person {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("name: String");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("friends: List<Person>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("op findFriend(Person name) : Person {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("for (var int i = 0; i < friends.size; i++) {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("val friend = friends.get(i)");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("if (friend.name.equals(name)) {");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("return friend");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return null");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package my.model;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import java.util.List;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class Person {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setName(final String name) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.name = name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private List<Person> friends;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public List<Person> getFriends() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.friends;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setFriends(final List<Person> friends) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.friends = friends;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Person findFriend(final Person name) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("for (int i = 0; (i < this.friends.size()); i++) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("final Person friend = this.friends.get(i);");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("boolean _equals = friend.name.equals(name);");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("if (_equals) {");
      _builder_1.newLine();
      _builder_1.append("          ");
      _builder_1.append("return friend;");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return null;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}