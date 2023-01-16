<template>
  <transition name="modal-fade">
    <div class="modal-backdrop">
      <div class="modal"
        role="dialog"
        aria-labelledby="modalTitle"
        aria-describedby="modalDescription"
      >
<div class="form-group">
    <div>
        <label for="email">First Name</label>
        <input type="text" id="email" class="form-control" v-model="userData.firstName">
    </div>
    <div>
        <label for="email">Last Name</label>
        <input type="text" id="email" class="form-control" v-model="userData.lastName">
    </div>
    <div>
        <label for="age">Age</label>
        <input type="text" id="age" class="form-control" v-model="userData.age">
    </div>
    <div>
        <label for="age">Address</label>
        <input type="text" id="age" class="form-control" v-model="userData.address">
    </div>
    <div>
        <label for="age">Room Number</label>
        <input type="text" id="age" class="form-control" v-model="userData.roomNumber">
    </div>


</div>

<div>
<button
            type="button"
            class="btn-green"
            @click="submit"
            aria-label="Submit"
          >
            Submit
          </button>
    <button
            type="button"
            class="btn-green"
            @click="close"
            aria-label="Close modal"
          >
            Close
          </button>
</div>

      </div>
    </div>
  </transition>
</template>

<script>
import { HTTP } from '../axios/http-common'
  export default {
    name: 'dg-modal',
    data() {
                return {
                    userData: {
                        firstName: '',
                        lastName: '',
                        age: '',
                        address: '',
                        roomNumber: '',
                    }
                }
            },
    methods: {
      close() {
        this.$emit('close');
      },
      async submit(){
      const requestOptions = {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(this.userData)
        };
        const customerInfo = this.userData
        console.log('hello customerInfo ', customerInfo)
        console.log('  dfd', HTTP)
        await fetch(`/customers`,   requestOptions)
        this.close();
      }
    },
  };
</script>

<style>
  .modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .modal {
    background: #FFFFFF;
    box-shadow: 2px 2px 20px 1px;
    overflow-x: auto;
    display: flex;
    flex-direction: column;
  }

  .modal-header,
  .modal-footer {
    padding: 15px;
    display: flex;
  }

  .modal-header {
    position: relative;
    border-bottom: 1px solid #eeeeee;
    color: #4AAE9B;
    justify-content: space-between;
  }

  .modal-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
  }

  .modal-body {
    position: relative;
    padding: 20px 10px;
  }

  .btn-close {
    position: absolute;
    top: 0;
    right: 0;
    border: none;
    font-size: 20px;
    padding: 10px;
    cursor: pointer;
    font-weight: bold;
    color: #4AAE9B;
    background: transparent;
  }

  .btn-green {
    color: white;
    background: #4AAE9B;
    border-radius: 2px;
  }

  .modal-fade-enter,
  .modal-fade-leave-to {
    opacity: 0;
  }

  .modal-fade-enter-active,
  .modal-fade-leave-active {
    transition: opacity .5s ease;
  }
</style>