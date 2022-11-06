<template>
<div>
<h1>{{ msg }}</h1>
<div class="form-control">
        <label>First Name</label>
        <input type="text" v-model="firstName" name="firstName" placeholder="Enter fist Name" />
      </div>
      <div class="form-control">
        <label>Last Name</label>
        <input
          type="text"
          v-model="lastName"
          name="age"
          placeholder="Enter last name"
        />
      </div>
      <input type="submit" value="Save Information" class="btn btn-block" />
</div>



</template>

<script>
export default {
  name: 'Dashboard',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("/api/hello")
      .then((response) => response.text())
      .then((data) => {
          this.msg = data;
      });
  }
}
</script>