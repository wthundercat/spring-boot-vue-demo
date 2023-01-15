<template>
<div>
<h1>Dashboard</h1>
<div class = "center">
       <table class="table table-striped table-bordered">
                   <thead>
                       <tr>
                       <th>CustomerId</th>
                           <th>First Name</th>
                           <th>Last Name</th>
                           <th>Age</th>
                           <th>Address</th>
                           <th>Room Number</th>

                       </tr>
                   </thead>
                   <tbody>
                       <tr v-for="customer in customers" :key="customer.id">
                       <td>{{customer.customer_id}} </td>
                           <td>{{customer.firstName}} </td>
                           <td>{{customer.lastName}}</td>
                           <td>{{customer.age}}</td>
                           <td>{{customer.address}}</td>
                           <td>{{customer.rooms[0].roomNumber}}</td>
                           <td><Button>Remove Customer</Button></td>
                       </tr>
                   </tbody>
               </table>
           </div>

    <button
      type="button"
      class="btn"
      @click="showModal"
    >
      Add New Customer
    </button>

 <dg-modal v-show="isModalVisible"
                 @close="closeModal">


      <template v-slot:header>
          This is a new modal header.
        </template>

        <template v-slot:body>
          This is a new modal body.
        </template>

        <template v-slot:footer>
          This is a new modal footer.
        </template>
  </dg-modal>
</div>



</template>

<script>
  import ModalWindow from './ModalWindow.vue';

export default {
  name: 'dg-dashboard',
  components:{
      'dg-modal': ModalWindow
     },
  data() {
    return {
      customers: [{"id":1,"name":"XlsjMItWWHEUnqQpoqYK","age":"33.2183974441985041750698554077186763388","salary":"881.756500351126174274614418318494758655","address":"Berlin"}],
              isModalVisible: false

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
  },
  methods: {
        showModal() {
          this.isModalVisible = true;
        },
        closeModal() {
          this.isModalVisible = false;
        }
      }
}
</script>

<style>
table {
  font-family: 'Open Sans', sans-serif;
  width: 750px;
  border-collapse: collapse;
  border: 3px solid #44475C;
  margin: 10px 10px 0 10px;
}

table th {
  text-transform: uppercase;
  text-align: left;
  background: #44475C;
  color: #FFF;
  padding: 8px;
  min-width: 30px;
}

table td {
  text-align: left;
  padding: 8px;
  border-right: 2px solid #7D82A8;
}
table td:last-child {
  border-right: none;
}
table tbody tr:nth-child(2n) td {
  background: #D4D8F9;
}
.center {
  margin: auto;
  width: 60%;
  padding: 10px;
}

</style>