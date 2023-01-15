<template>
  <transition name="modal-fade">
    <div class="modal-backdrop">
      <div class="modal"
        role="dialog"
        aria-labelledby="modalTitle"
        aria-describedby="modalDescription"
      >
<div class="form-group">
    <label for="email">First Name</label>
    <input type="text"
           id="email"
           class="form-control"
           v-model="userData.firstName">

            <label for="email">Last Name</label>
               <input type="text"
                      id="email"
                      class="form-control"
                      v-model="userData.lastName">
</div>
<div class="form-group">
    <label for="email">Age</label>
    <input type="text"
           id="email"
           class="form-control"
           v-model="userData.firstName">

            <label for="email">Address</label>
               <input type="text"
                      id="email"
                      class="form-control"
                      v-model="userData.lastName">

                       <label for="email">Room Number</label>
                                     <input type="text"
                                            id="email"
                                            class="form-control"
                                            v-model="userData.lastName">
</div>
<div>
<button
            type="button"
            class="btn-green"
            @click="close"
            aria-label="Close modal"
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
  export default {
    name: 'dg-modal',
    data() {
                return {
                    userData: {
                        firstName: '',
                        lastName: ''
                    }
                }
            },
    methods: {
      close() {
        this.$emit('close');
      },
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