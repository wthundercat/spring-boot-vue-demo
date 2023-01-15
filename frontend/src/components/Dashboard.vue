<template>
<div>
<h1>Dashboard</h1>
       <table class="table table-striped table-bordered">
                   <thead>
                       <tr>
                       <th>CustomerId</th>
                           <th>Name</th>
                           <th>Age</th>
                           <th>Salary</th>
                           <th>Address</th>

                       </tr>
                   </thead>
                   <tbody>
                       <tr v-for="customer in customers" :key="customer.id">
                       <td>{{customer.id}} </td>
                           <td>{{customer.name}} </td>
                           <td>{{customer.age}}</td>
                           <td>{{customer.salary}}</td>
                           <td>{{customer.address}}</td>
                       </tr>
                   </tbody>
               </table>
</div>



</template>

<script>
export default {
  name: 'dg-dashboard',
  data() {
    return {
      customers: [{"id":1,"name":"XlsjMItWWHEUnqQpoqYK","age":"33.2183974441985041750698554077186763388","salary":"881.756500351126174274614418318494758655","address":"Berlin"}]
    }
  },
  mounted() {
    fetch("/customers")
      .then((response) => response.text())
      .then((data) => {
          this.customers = JSON.parse( data);
                console.log ("hello   ", this.customers)

                          console.log ("hello 2  ", this.customers[0].id)

      });
  }
}
</script>

<style>
table, th, td {
  border: 1px solid black;
}
</style>