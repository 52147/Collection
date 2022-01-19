package collectionapi;
/**
 * = implementing equals and hashCode =
 * 
 * - Overriding equals is very tricky when inheritance is involved.
 * - The contract for equals states that if p and q are not null, p.equals(q) should
 *   return the same value as q.equals(p).
 * - This does not occur in this program.
 * - In that example, clearly b.equals(c) return true, as expected.
 * - a.equals(b) also returns true, because BaseClass's equals method is used, 
 *   and that only compares the x components.
 * 
 * - However, b.equals(a) returns false, because DerivedClass's equals method is used,
 *   and the instanceof test will fail
 *   (a is not an instance of DerivedClass).
 *   
 *   
 * - There are 2 standard solution to this problem.
 * - One
 */
public class BaseClass {

}
