<template>
  <div>
    <i
      class="fa fa-bars"
      aria-hidden="true"
      :style="{transform: (isCollapse ? 'rotate(90deg)' : 'rotate(0deg)')}"
      @click="handleClick"
    />
  </div>
</template>

<script>
export default {
  name: 'SideTrigger',
  props: {
    isCollapse: {
      type: Boolean,
      default: false,
    },
  },
  methods: {
    handleClick() {
      this.$emit('on-change', !this.isCollapse);
    },
  },
};
</script>
