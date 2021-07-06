In this challenge you will use your JSP knowledge to build a page with several functionalities in Java.

You have been provided with the necessary dependencies and plugins in your `pom.xml`. You have also been provided with the `WEB-INF/web.xml` file, and mostly-empty `index.jsp` and `DonutOrdersServlet` files. The JSTL dependency has also been provided should you want to use it.

## Getting Started

```no-highlight
et get jsp-donut-orders
cd jsp-donut-orders
```

You have been tasked by your office to keep track of the number of orders needed for Donut Day (a Friday morning ritual that every company should embrace). We want a webpage to refer to so that we can know exactly how many donuts to buy and deliver to which employees, so let's use JSP and Tomcat to build a Java webapp!

## Core User Stories

```no-highlight
As a donut runner for my team
I want to see a list of how many donuts to buy for each person
So that I can make sure to not skimp on treats
```

Acceptance Criteria:

- When I visit `/orders`, I see a header that says "Donut Orders"
- I also see list of all employees who want donuts
- Next to each name is the number of donuts they want
- At the bottom of the list is the total number of donuts to buy

Implementation Details:

- There should be an unordered list on the page
- Each person's name and number of donuts should be displayed in a list item
- Note that you've been provided with a list of employees in your servlet
- **Hint:** if you want to hand a `Map` as an attribute to JSP, you will need to cast it on the other side. E.g., do the following in your JSP file:
```
Map<String, Integer> donutOrders = (Map)request.getAttribute("donutOrders");
```


```no-highlight
As a donut runner
I want to make sure people don't order too many donuts
So that people don't take advantage of donut day
```

Acceptance Criteria:

- If a person is ordering 5 or fewer donuts, we should see their name and quantity on the page as normal
- If the person is ordering more than 5 donuts, we should _instead_ see a message saying that we should talk to them about not trying to game the donut system (and the perils of sugar crashes!)
- We can also add their name to the list with a modest 2 donuts for this week
- Be sure to update the "total" number of donuts to include the proper number!

```no-highlight
As a donut runner
I want to know what people's favorite donuts are
So I can try to surprise them with their favorites
```

Acceptance Criteria:

- When I navigate to `/orders?name=<name>`, I can see information about the team member whose name I have supplied
- I will see the name of the person, as well as the number of donuts they have ordered
- If the person in question has a favorite donut, I will also see that listed on the page, e.g.: `Favorite Donut: <name of donut>` on the page.
- If a person's favorite donut is not found, it should simply skip outputting their favorite, including the label.

Implementation Details:

- When providing a name as a query string, you'll want to render a new JSP view template, `show.jsp`
- Without breaking your existing functionality, implement logic to check if a name has been provided, and determine which template to render
- If a name is provided which does not match an existing employee, output a message "That team member cannot be found!" on the page
- If a name is provided which does exist, add the team member's name and quantity of donuts to the page
- Define a new HashMap in your Servlet which matches an employee's name to the name of their favorite donut (hint: don't include every single employee, so that you can test your edge cases!)
- Then, use this HashMap to _conditionally_ add the favorite donut to the page