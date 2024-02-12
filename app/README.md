1. https://github.com/selwynsg/assignment2.git
2. press play and enter the username and password: admin admin

Brief description:
Project that uses the recycleview, adapter class, fragments, and activity to create a product list.
Two main products, Food and Equipment, which are represented in a sealed class called ProductType.
Each of the products are its own dataclasses. The login page is a simple fragment that checks 
if the password and username are equal to admin. If so, it will navigate to the ProductListFragment.
Th ProductListFragment creates a view and calls on the recycle view to display the different products.
The products are parsed in the sealed class and is classified into its different types. Then, it is 
displayed.